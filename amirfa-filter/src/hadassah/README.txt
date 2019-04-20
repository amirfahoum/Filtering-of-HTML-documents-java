Name:Amir Fahoum

mail:amirfahoum@gmail.com

ex1:
we Creat 6 class :
Web Page filter , as interface that have accept functon
Web page filterfactory: that implement from webpagefilter  , in these class we have accept function and creatwebpagefilter   that return new webpagefactory filter
Restrictedview:  as a main that get from args the parametrs and insert them to new arr that store the all user paramter ,  
RejectJavaScriptFilter class that implement from webpagefilter: theat have a accept function , that check if the file contain any java script we did the check by search about keyword <script<
if we found those tags then we return false; so the file contain java script, if we didnt find any <script> then the function return true
EnglishDocumentsFilter class that implement from webpagefilter
this class check if the file contain english key words , that describe the the data ib the file is in english not in any other langauge  , , we do the check by sett array of strings and check if any string equal to  the data in file.

CompositeWebPageFilter got constructor the save the List of filters , and got accept function that check if the program accept the file , by run  accept function by object . 



overview:


after that we make a connection to the url that the user entered , using URL connection 
and inputstream, 
we read the user input and connect to the web page after that  we recive an html file , and save it content 
then we make some check according to the user input , for example we run accept function that in englishdoucment filter check class and then we run accept function that in rejectjava script class
iif we get accept from both filters then we print its content else we print a message acces denied
, the user can creat his own filter . 
note: i use my own html remover tags


we Used intellij to write the code ,with java lang.
