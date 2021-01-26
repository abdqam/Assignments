public class StringManipulator{
    public String trimAndConcat(String str1,String str2){
        String result = (str1.trim()).concat(str2.trim());
        return result;
    }
    public Integer getIndexOrNull(String str,char c){
        int index = str.indexOf(c);
        if(index<0){
            return null;
        }
        else{
            return index;
        }
    }
    public Integer getIndexOrNull(String str1, String str2){
        int index = str1.indexOf(str2);
        if(index<0){
            return null;
        }
        else{
            return index;
        }
        
    }
    public String concatSubstring(String str1, int start, int end, String str2){
        String result = str1.substring(start, end);
        result = result.concat(str2);
        return result;
    }
}