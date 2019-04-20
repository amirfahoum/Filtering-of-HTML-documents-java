package hadassah;

    public class  WebPageFilterFactory implements WebPageFilter {
        String Keyf;
        WebPageFilterFactory()//empty constructor
        {
        }
        WebPageFilterFactory(String filterName)
        {

             Keyf=filterName;//save the filter name as member (constructor)
        }

        @Override
        public boolean accept(String url, String content)
        {
            if(content.contains(Keyf))//check if key in content
            {
                return true;
            }
        return false;
        }


        public WebPageFilter creatWebPageFilter(String filterName)
        {
            return  new WebPageFilterFactory(filterName);//return new webpagefilter

        }
    }

