class Solution {


    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String s: strs) {
            // so it is 4#love5#daddy9#cognizant
            // # alone isn't enough incase the word has # in it actually, so we add the number too
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // So we are taking advantage of substring so that wherever we are
            // w/ i and j we can get the length. The length could alo be 100, mind you
            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1; // so i = left and j = right; this resets so i is able to process next word
            j = i + length; // j moves all the way to the end of the word with length
            res.add(str.substring(i, j)); // we just get it with subtring
            i = j;
        }
        return res;
    }
}

/*
This is the more optimal solution that needcode suggested: https://www.youtube.com/watch?v=B1k_sxOSgv8

This actually made more sense to me and had shorter code.

O (m+n) for each encode and decode function calls
O (m+n) for each encode and decode function calls
*/
