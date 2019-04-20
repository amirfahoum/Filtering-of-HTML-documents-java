package hadassah;
import java.util.ArrayList;

public class CompositeWebPageFilter implements  WebPageFilter

{

    public  ArrayList<WebPageFilter> filelist;
    CompositeWebPageFilter(ArrayList<WebPageFilter> List1 )
    {
        filelist=new ArrayList<WebPageFilter>(List1);//set file list using copy constructor


    }
    @Override
    public boolean accept(String url, String content) {
        for(int i=0;i<filelist.size()-1;i++)

        {
            if (!filelist.get(i).accept(url,content))//if any accept function from englishfilter\rejectjava then print
            {
                System.out.println("access denied");
                return false;

           }

        }
        return true;//else return true;
    }

}
