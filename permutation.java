// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

// Hide Tags Backtracking
// Hide Similar Problems (M) Next Permutation (M) Permutations II (M) Permutation Sequence (M) Combinations

// please follow the backtracking template in Evernote
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
         if (nums == null || nums.length == 0) {
             return rst; 
         }

         List<Integer> list = new ArrayList<Integer>();
         permuteHelper(rst, list, nums);
         return rst;
    }
    
    public void permuteHelper(List<List<Integer>> rst, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));  // need to create a new list, but why? seems that because list itself just an address?
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(rst, list, nums);
            list.remove(list.size() - 1);
        }
    }
}

// Thanks to: http://blog.csdn.net/TigerMee/article/details/9125047
// - // array: 保存了[0, step-1]每一步的选择
// - // step: 当前是第几步
// -
// - backtracking(array, step)
// - {
// -     // 判断前step步的选择是否可以构成一个结果
// -     if (is_a_solution(array, step)) {
// -         process_solution(array, step);
// -     } else {
// -         step++;
// -         // 获取下一步的所有选择
// -         condidates = construct_candidates(array, step);
// -         foreach c in condidates {
// -             // 对每一种选择，继续递归下去
// -             array[step] = c;
// -             make_move(array, step);
// -             backtracking(array, step);
// -             unmake_move(array, step);
// -         }
// -     }

// 其中重要函数有这样几个：

// - is_a_solution：判断当前组合是否是一个期望的结果
// - process_solution：处理结果，例如打印出来
// - construct_candidates：获取下一步的所有选择。注意，这里并没有说明如何选择下一步该如何进行，大多数情况下，这个函数还应当有选择下一步的功能，即剪枝。
// - make_move：向前进一步。通常这意味着在array中填充这一步的所选择的的值
// - unmake_move：向后退一步。通常这意味着在array中将这一步的值清空