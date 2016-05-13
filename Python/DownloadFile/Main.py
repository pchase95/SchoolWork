from urllib import request
import webbrowser
import os

site = 'http://www.mcla.edu/news1/2015-August/stem-academy-leads-to-major-decision'

def downloadPage(url):
    response = request.urlopen(url)
    output = response.read()
    output_str = str(output)
    return output_str

fw = open('meme.html','w')
fw.write(downloadPage(site))

path = os.getcwd() + '/meme.html'
chrome = webbrowser.get('google-chrome')
chrome.open(path, new=2, autoraise=True)
