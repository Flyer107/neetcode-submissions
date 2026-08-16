class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Build the graph and the email-to-name mapping
        for (List<String> name_emails: accounts) {
            // .get(0) is the name, so .get(1) to get the first email
            String name = name_emails.get(0);

            if(name_emails.size() < 2) continue;

            String firstEmail = name_emails.get(1);
            emailToName.put(firstEmail, name);

            // Loop starts at index 2 to grab every email AFTER the first email
            for(int i = 2; i < name_emails.size(); i++) {
                String currentEmail = name_emails.get(i);
                emailToName.put(currentEmail, name);
                // computeIfAbsent line does this:
                // 1. checks if the email already exists as key in the map
                //      No -> execute lambda to createa brand new empty arraylist
                //      Yes -> Return that list then insert the current email
                adj.computeIfAbsent(firstEmail, k -> new ArrayList<>()).add(currentEmail);

                // Create the undirected Edge.
                // For bfs or dfs to work relationship must be a two-way street
                // So exact same computeIfAbsent logic in reverse, adding first email to the neighbor list of accounts.get(i)
                adj.computeIfAbsent(currentEmail, k -> new ArrayList<>()).add(firstEmail);

            }
        }

        // Step 2: Traveres teh graph to find connected components
        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();

        for (String email: emailToName.keySet()) {
            if (!visited.contains(email)) {
                List<String> emailCluster = new ArrayList<>();

                // DFS to gather all connected emails
                dfs(adj, visited, email, emailCluster);

                Collections.sort(emailCluster);

                // Fetch the name using any email in the cluster
                String name = emailToName.get(email);

                // Insert name at the start of the list
                emailCluster.add(0, name);

                mergedAccounts.add(emailCluster);
            }
        }

        return mergedAccounts;
    }

    private void dfs(Map<String, List<String>> adj, Set<String> visited, String email, List<String> emailCluster) {
        visited.add(email);
        emailCluster.add(email);

        if (adj.containsKey(email)) {
            for (String neighbor: adj.get(email)) {
                if (!visited.contains(neighbor)) {
                    dfs(adj, visited, neighbor, emailCluster);
                }
            }
        }

    }

    /*Clues: "Two accounts definitely belong to the same person if there is some common email to both accounts."

This describes a transitive relationship. If Account A shares an email with Account B, and Account B shares an email with Account C, then all the emails in A, B, and C belong to the exact same person.*/
}