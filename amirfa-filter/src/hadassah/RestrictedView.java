package hadassah;
import java.net.URL;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.MalformedURLException;



public class RestrictedView {
    public static void main(String[] args){
        try {
            // using https://www.w3schools.in/java-program/read-url-content-in-java/
            if (args == null) {
                System.out.println("the program run with out paramaters, the default filters and javascript and english");


            }
            String[] arr = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                arr[i] = args[i];
            }
            String URL1 = arr[args.length - 1];
            String Content = " ";
            String parseLine; /* variable definition *//* create objects */
            URL url = new URL(URL1);

            URLConnection connection = (url).openConnection();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));


            while ((parseLine = br.readLine()) != null) {
                /* read each line */
                Content = parseLine + Content;

            }
            br.close();


            EnglishDocumentsFilter Eng1 = new EnglishDocumentsFilter();//creat english filter obj
            RejectJavaScriptFilter Rej1 = new RejectJavaScriptFilter();//creat rej filter obj
            ArrayList<WebPageFilter> arrayLis = new ArrayList<WebPageFilter>();//creat arraylist that contain objects
            arrayLis.add(Rej1);//add to it rej object
            arrayLis.add(Eng1);//add to eng object

            for (int x = 0; x < arr.length - 1; x++)//goes over the string that the user enters
            {
                if (arr[x].equals("english"))
                    arrayLis.add(Eng1);
                if (arr[x].equals("Javascript"))
                    arrayLis.add(Rej1);
                else {//if the user enter somthing different than english and javascript it will creat  new filter
                    WebPageFilterFactory Userfilter = new WebPageFilterFactory();
                    Userfilter.creatWebPageFilter(arr[x]);
                    arrayLis.add(Userfilter);
                }
            }
            CompositeWebPageFilter comp = new CompositeWebPageFilter(arrayLis);


            if (comp.accept(URL1, Content)) {
               Content= Content.replaceAll("(<.*?>)|(&.*?;)|([ ]{2,})", " ");//removing html tags
                System.out.println("the content of the text:");
                    System.out.println(Content);


            }

        }
     catch (MalformedURLException me) {
        System.out.println(me);

    } catch (IOException ioe) {
        System.out.println(ioe);
    }
    }
};

