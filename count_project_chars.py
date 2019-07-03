# encoding=utf-8
import os
import re
import time

code_extensions = [
    '.java',
    # '.html',
    '.css',
    '.js',
    '.jsp',
    '.sql',
    '.svg',
]
ignore_files = ['build', 'test']


def count_file(path):
    counter = 0
    if os.path.isdir(path):
        file_list = os.listdir(path)
        for filename in file_list:
            filepath = f'{path}/{filename}'

            if True in (ignore_file in filepath for ignore_file in ignore_files):
                continue

            counter += count_file(filepath)
    else:
        basename, ext = os.path.splitext(path)
        if ext in code_extensions:
            with open(path, encoding='utf-8') as code_file:
                for line in code_file:
                    counter += len(line)

            print(f'{counter} - {path}')

    return counter


if __name__ == "__main__":
    chars_count = count_file('.')
    print('chars_count:', chars_count)
