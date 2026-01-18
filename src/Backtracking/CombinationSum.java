package Backtracking;

import java.util.*;

// [Medium] https://leetcode.com/problems/combination-sum/description/
// https://www.youtube.com/watch?v=GBKI9VSKdGg&ab_channel=NeetCode
// [Medium] [See Editorial] [Following TLE] https://leetcode.com/problems/combination-sum-ii/description/
// https://www.youtube.com/watch?v=FOyRpNUSFeA&ab_channel=NeetCodeIO
// [Medium] https://leetcode.com/problems/combination-sum-iii/description/
public class CombinationSum {
    private Set<List<Integer>> combinations;
    private void combinationSum(int[] candidates, int target, int n, List<Integer> combination){
        if(target == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if(target < 0 || n >= candidates.length)
            return;

        if(target - candidates[n] >= 0){
            combination.add(candidates[n]);
            combinationSum(candidates, target - candidates[n], n+1, combination );
            combination.remove(combination.size() - 1);
            combinationSum(candidates, target, n+1, combination );
        }
        else{
            combinationSum(candidates, target, n+1, combination );
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combinations = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());

        return new ArrayList<>(combinations);
    }

    public static void main(String[] args) {

    }
}
