#!/usr/bin/env python
# coding: utf-8

# In[1]:
import os
import codecs
import pymysql
from textrank4zh import TextRank4Keyword, TextRank4Sentence

# In[2]:


dirPath = r"C:/Users/Administrator/DBdata/Transcript_file"
#result = [f for f in os.listdir(dirPath) if os.path.isfile(os.path.join(dirPath, f))]
pathname = []
file = []
for f in os.listdir(dirPath):
    if os.path.isfile(os.path.join(dirPath, f)):
        file += [f]
        pathname += [dirPath + '/' + f]

i = 0
for r in pathname:
    text = codecs.open(r, 'r', 'utf-8').read()
    tr4s = TextRank4Sentence()
    tr4s.analyze(text=text, lower=True, source = 'all_filters')

    os.chdir(r'C:/xampp/htdocs/Summary_file')
    txt = codecs.open(file[i], 'w')
    print(file[i])
    i += 1
    for item in tr4s.get_key_sentences(num = 3):
    #print(item.index, item.weight, item.sentence)
        txt.write(item.sentence)
        print(item.sentence)
    txt.close()

# In[35]:


dirPath = r"C:/xampp/htdocs/Summary_file"
pathname = []
filename = []
filenum = []
for f in os.listdir(dirPath):
    if os.path.isfile(os.path.join(dirPath, f)):
        pathname += [dirPath + '/' + f]
        filename += [f]
        filenum += [f.replace('.txt', '')]
print(pathname)
print(filename)
print(filenum)


# In[36]:


db_settings = {
    "host": "127.0.0.1",
    "port": 3306,
    "user": "6teen",
    "password": "tkuim6teen",
    "db": "inote",
    "charset": "utf8"
}

try:
    for i in range(len(filenum)):
        conn = pymysql.connect(**db_settings)
        with conn.cursor() as cursor:
            command = "UPDATE summary SET path = %s WHERE summary_id = %s "

            #cursor.executemany( command, (pathname, filenum) )
            cursor.execute( command, (pathname[i], filenum[i]) )
            conn.commit()
except Exception as ex:
    print(ex)

