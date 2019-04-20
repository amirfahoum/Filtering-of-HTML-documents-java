package hadassah;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnglishDocumentsFilter implements WebPageFilter//english filter check
{
        @Override
        public boolean accept(String url, String content) {
                Integer count=0;
                String[] L= {"to","the","from","are","is","More","or,for"};

                for(int i=0;i<L.length;i++)
                {

                        if(content.contains(L[i]))
                        {

                                count++;
                                break;
                        }

                }

                if(count==0)
                {
                        System.out.println("no english");
                        return false;
                }
                else
                {
                        System.out.println("english");
                        return true;
                }

        }

}

