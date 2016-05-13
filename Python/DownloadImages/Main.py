import urllib.request

def getImage(url):
    name = 'pepe' + url[-3:]
    urllib.request.urlretrieve(url, name)

getImage('https://40.media.tumblr.com/8661041b26d1f4b05883a24e48ed35cd/tumblr_inline_o67ojpRKX31u6d6kp_540.jpg')
