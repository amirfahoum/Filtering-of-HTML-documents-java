package hadassah;

public class RejectJavaScriptFilter implements WebPageFilter{ //java filter check
    @Override
    public boolean accept(String url, String content) {
        String s1 = "<script>";//check if s1 contain in content
        if (content.contains(s1)){
            System.out.println("script ");
        return false;
        }
        else{
            System.out.println("no script");
            return true;
        }
    }
}
