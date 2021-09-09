public class Solution014 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].equals("")) return "";
        if(strs.length == 1) return strs[0];
        StringBuilder sb = new StringBuilder();
        // i means the ith char in string
        for(int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            boolean equal = true;
            // j means the jth string in strs array
            for(int j = 1; j < strs.length; j++){
                if(strs[j].equals("")) return "";
                if(i == strs[j].length() || strs[j].charAt(i)!=c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flower"};
        System.out.println(longestCommonPrefix(strs));
    }
}
