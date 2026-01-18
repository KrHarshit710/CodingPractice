package Graph.UnionFind;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/description/
public class AccountsMerge {
    private int[] parent;
    private int[] rank;
    private int find(int i){
        if(parent[i] != i)
            parent[i] = find(parent[i]);

        return parent[i];
    }
    private void union(int i, int j){
        int iParent = find(i);
        int jParent = find(j);

        if(iParent == jParent)
            return;

        int iRank = rank[i];
        int jRank = rank[j];

        if(iRank < jRank){
            parent[iParent] = jParent;
        } else if( jRank < iRank){
            parent[jParent] = iParent;
        } else {
            parent[jParent] = iParent;
            rank[iParent]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        Map<String, Integer> email_account_map = new HashMap<>();
        int accountNo = 0;
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++) {
                if(email_account_map.containsKey(accounts.get(i).get(j))){
                    union(i, email_account_map.get(accounts.get(i).get(j)));
                } else {
                    email_account_map.put(accounts.get(i).get(j), i);
                }
            }
        }

        Map<Integer, SortedSet<String>> merged_email_map = new HashMap<>();
        SortedSet<String> emails;
        for(int i=0; i<n; i++){
            emails = merged_email_map.getOrDefault(find(i), new TreeSet<>());
            for(int j=1; j<accounts.get(i).size(); j++)
            {
                emails.add(accounts.get(i).get(j));
            }
            merged_email_map.put(parent[i], emails);
        }

        List<List<String>> mergedAccount = new ArrayList<>();
        for(Map.Entry<Integer, SortedSet<String>> entry : merged_email_map.entrySet()){
            List<String> account = new ArrayList<>();
            account.add(accounts.get(entry.getKey()).get(0));
            account.addAll(entry.getValue());
            mergedAccount.add(account);
        }

        return mergedAccount;
    }
    public static void main(String[] args) {

    }
}
