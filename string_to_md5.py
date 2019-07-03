# encoding=utf-8
import hashlib

if __name__ == "__main__":
    # m = hashlib.md5()
    # encoded_str = 'Essential skills for a happy life!20151116 23:50:00article'.encode('utf-8')
    # print(encoded_str)
    # m.update(encoded_str)
    # print(m.digest())
    # x = 'Essential skills for a happy life!20151116 23:50:00article'
    # x = 'You\'ve gotta dance20151116 15:50:00quote'
    # x = 'Photo20151116 07:50:00photo'
    x = 'LAB321-Blogging'
    print(x)
    print(hashlib.md5(x.encode('utf-8')).hexdigest())