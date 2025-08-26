public class Challenge11 {
     
    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() % 2 != 0) return false;

        String old = s;
        
        while (true) {
            String temp = old.replace("()", "")
                             .replace("{}", "")
                             .replace("[]", "");
            if (temp.equals(old)) {
                
                break;
            }
            old = temp;
        }
        
        return old.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));       
        System.out.println(isValid("([)]"));     
        System.out.println(isValid("[{()}]"));   
        System.out.println(isValid(""));         
        System.out.println(isValid("{[}"));      
    }
}