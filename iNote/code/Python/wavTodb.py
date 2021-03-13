#!/usr/bin/env python
# coding: utf-8

# In[1]:


import os
import glob
import numpy as np
import scipy.io.wavfile as wav

import pymysql
import sys


# In[2]:

meeting_id = sys.argv[1]

db_settings = {
    "host": "127.0.0.1",
    "port": 3306,
    "user": "6teen",
    "password": "tkuim6teen",
    "db": "inote",
    "charset": "utf8"
}
result = []

try:
    conn = pymysql.connect(**db_settings)
    with conn.cursor() as cursor:
        command = "SELECT pathname FROM wav WHERE meeting_id = %s"
        
        #cursor.execute( command )
        cursor.execute(command, (meeting_id))
        
        result += cursor.fetchall()
        print(result)
except Exception as ex:
    print(ex)


# In[3]:

merged_signal = []
for tuple in result:
    for filename in tuple:
        sr, signal = wav.read(filename)
        merged_signal.append(signal)
print(merged_signal)
merged_signal=np.vstack(merged_signal)
merged_signal = np.asarray(merged_signal, dtype=np.int16)
fn = '/Users/jo/Desktop/wavFile/' + meeting_id  + '.wav'
wav.write(fn , sr, merged_signal)
print("complete!")


# In[4]:


try:
    conn = pymysql.connect(**db_settings)
    with conn.cursor() as cursor:
        command = "INSERT INTO wav( pathname, meeting_id )VALUES( %s, %s )"
        
        cursor.execute( command, ( fn, meeting_id ) )
        conn.commit()
except Exception as ex:
    print(ex)


# In[ ]:




