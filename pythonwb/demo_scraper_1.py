import requests;
from bs4 import BeautifulSoup

url = "https://www.smallcase.com/smallcase/SCNM_0008"
response = requests.get(url);
html = response.content
soup = BeautifulSoup(html)
print(soup.prettify())