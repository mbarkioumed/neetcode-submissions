class Solution {

    public String encode(List<String> strs) {

        if(strs.size() == 0){
            return "size0";
        }

        String res = "";

        for(String str : strs){
            res += str + "///";
        }

        return res;
    }

    public List<String> decode(String str) {
        if(str.equals("///")){
            List<String> lst = new ArrayList<>();
            lst.add("");
            return lst;
        }
        if(str.equals("size0")){
            return new ArrayList<>();
        }
        return Arrays.asList(str.split("///"));
    }
}
