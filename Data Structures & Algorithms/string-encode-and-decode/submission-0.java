class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder res = new StringBuilder();
        List<Integer> sizes = new ArrayList<>();

        // Loop through all the words and add the lengths to a list
        for (String str: strs) {
            sizes.add(str.length());
        }

        // Within the res we append the size of the word and a comma
        for (int size: sizes) {
            res.append(size).append(',');
        }
        res.append('#');

        // so first it is 4,5,9,# then to 4,5,9,#lovedaddycognizant
        for (String str: strs) {
            res.append(str);
        }

        return res.toString();

    }

    public List<String> decode(String str) {
        if (str.length() == 0 ) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        // So this loops through all the sizes and ',' in 4,5,9,#lovedaddycognizant
        // when we reach the actual words, we break out. becomes -> 459
        int i = 0; 
        while (str.charAt(i) != '#') {
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }
        i++;

        // At this point i is where the '#' marker is.
        // so we add each word going size by size from there
        for (int sz : sizes) {
            res.add(str.substring(i, i + sz));
            i += sz;
        }
        return res;

    }
}

/*
O (m+n) for each encode and deconde function calls
O (m+n) for each encode and decode function calls
*/
