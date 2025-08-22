public class Challenge7 {
    public static String reverseWords(String s) {
        
        String[] parts = s.split(" ");
        
        String result = "";
        
        
        for (int i = parts.length - 1; i >= 0; i--) {
            if (!parts[i].equals("")) {  
                result = result + parts[i] + " ";
            }
        }
        
        
        if (result.equals("")) {
            return "";
        }
        
        
        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        //Test case 1
        System.out.println(reverseWords("the sky is blue"));   
        //Test case 2
        System.out.println(reverseWords("  hello world  "));   
        //Test case 3
        System.out.println(reverseWords("a good   example"));  
        //Test case 4
        System.out.println(reverseWords("    "));              
        //Test case 5
        System.out.println(reverseWords("word"));              
    }
}