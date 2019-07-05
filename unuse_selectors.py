# encoding=utf-8
import os
import re
import time

import cssutils


def extract_html(html_filename):
    assert os.path.exists(html_filename)

    tag_list = []
    class_list = []

    with open(html_filename, encoding='utf-8') as inp_file:
        for line in inp_file:
            _tag_list = re.findall(r'<\w+', line)
            _tag_list = list(map(lambda x: x[1:], _tag_list))

            tag_list.extend(_tag_list)

            _class_list = re.findall(r'class="[\w\-\s]+"', line)
            _class_list = list(map(lambda x: x[7:-1], _class_list))

            for class_text in _class_list:
                class_list.extend(class_text.split())

    return set(tag_list), set(class_list)


def extract_css(css_filename):
    selector_list = []
    css_filename = 'web/css/index.css'
    sheet = cssutils.parseFile(css_filename)
    for rule in sheet:
        if isinstance(rule, cssutils.css.cssstylerule.CSSStyleRule):
            selector_text = rule.selectorList.selectorText
            # heading>h1 --> heading > h1
            # heading> h1 --> heading >  h1
            # heading >h1 --> heading  > h1
            # heading > h1 --> heading  >  h1
            selector_text = re.sub(r'>', ' > ', selector_text)
            _selector_list = selector_text.split()
            selector_list.extend(_selector_list)

    tag_list = []
    class_list = []

    for selector in selector_list:
        _tag_list = re.findall(r'^(?!\.)\w+', selector)
        tag_list.extend(_tag_list)

        _class_list = re.findall(r'\.[\w\-]+', selector)
        _class_list = list(map(lambda x: x[1:], _class_list))
        class_list.extend(_class_list)
    return set(tag_list), set(class_list)


def selector_diff(html_files, css_files):
    html_tags_set = set()
    html_classes_set = set()
    for html_filepath in html_files:
        _tags_set, _classes_set = extract_html(html_filepath)
        html_tags_set.update(_tags_set)
        html_classes_set.update(_classes_set)

    css_tags_set = set()
    css_classes_set = set()
    for css_filepath in css_files:
        _tags_set, _classes_set = extract_css(css_filepath)
        css_tags_set.update(_tags_set)
        css_classes_set.update(_classes_set)

    tags_diff = css_tags_set - html_tags_set
    classes_diff = css_classes_set - html_classes_set

    return tags_diff, classes_diff


if __name__ == "__main__":
    html_files = [
        'web/index.jsp',
        'web/overview.jsp',
        'web/blog.jsp',
        'web/about.jsp',
    ]
    css_files = [
        'web/css/index.css'
    ]

    tags_diff, classes_diff = selector_diff(html_files, css_files)

    print('tags_diff:', tags_diff)
    print('classes_diff:', classes_diff)
