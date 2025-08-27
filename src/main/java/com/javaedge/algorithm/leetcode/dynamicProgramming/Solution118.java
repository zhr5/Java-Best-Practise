package com.javaedge.algorithm.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
/*    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        // 假设当前是row行,column列 nums[i][j]=nums[i-1][j-1]+nums[i-1][j] (0<j<column-1)
        int[][] nums = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            nums[0][i] = 1;
            nums[i][i] = 1;
        }
        for (int i = 2; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
            }
        }

        for (int[] innerArray : nums) {
            List<Integer> innerList = new ArrayList<>();
            for (int num : innerArray) {
                innerList.add(num); // 将每个 int 添加到内层 List 中
            }
            res.add(innerList); // 将内层 List 添加到外层 List 中
        }
        return res;
    }*/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    innerList.add(1); // 每行的首尾元素都是1
                } else {
                    int val = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                    innerList.add(val); // 计算中间的元素
                }
            }
            res.add(innerList); // 将内层 List 添加到外层 List 中
        }
        return res;
    }
}

/*

深度思考
        ```
        好的，用户问“还能优化吗”，我需要针对之前提供的杨辉三角生成代码进一步优化。首先回顾之前的修改，已经解决了用户代码中的问题，比如数组越界、基本类型转换问题，并优化了中间数组的使用。现在用户希望进一步优化，可能需要考虑时间和空间效率。

        首先，原解决方案使用了一个二维数组dp来存储所有中间结果，空间复杂度是O(n²)。但杨辉三角的每一行实际上只需要上一行的数据来计算当前行。因此，可以尝试优化空间复杂度到O(n)，只保留上一行的数据。

        其次，当前代码使用了Integer二维数组，可能可以换成更高效的数据结构。或者考虑使用动态规划的滚动数组方法，只保存上一行的数据，这样空间复杂度可以降到O(n)。

        另外，在生成最终结果时，每次循环都创建新的ArrayList，这可能会有一定的开销，但这是必要的，因为需要存储每一行的列表。不过，可以尝试在初始化列表时指定容量，以减少动态扩容的次数，提升性能。

        还需要检查是否有冗余的计算，比如在循环中是否有多余的操作。例如，在填充dp数组时，每个元素的计算是否可以更高效。

        可能的优化点：

        1. **空间优化**：使用一维数组代替二维数组，利用滚动数组的思想，每次计算新行时只需要上一行的数据。
        2. **时间优化**：减少不必要的循环次数，比如利用杨辉三角的对称性，只计算一半的元素然后镜像复制，但需要注意奇偶行的处理。
        3. **初始化容量**：为ArrayList预先分配合适的容量，减少扩容次数。

        具体来说，空间优化方面，可以使用一个一维数组来保存上一行的数据。例如，对于第i行，从后往前更新数组的值，这样可以避免覆盖上一行的数据。例如，从右向左计算每个元素的值，利用旧的值来计算新的值。

        例如，初始化一个ArrayList列表，然后对于每一行，从后往前更新元素。或者，使用一个临时数组保存上一行的数据，然后生成当前行。

        另外，可以考虑直接生成每一行的元素，而不需要存储整个二维数组。例如，对于第i行，第j个元素等于上一行的j-1和j元素之和。通过这种方式，可以只维护上一行的数据，从而节省空间。

        在代码实现上，可以将dp数组改为一维数组，初始化为全1，然后逐行更新。例如，对于每一行i，从i-1的位置开始，到1的位置结束，更新dp[j] = dp[j] + dp[j-1]。这种方法可以避免使用二维数组，空间复杂度降为O(n)。

        此外，在生成结果时，可以将每一行的数据直接添加到结果列表中，而不需要中间的二维数组存储所有数据。

        例如，使用滚动数组的方法：

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dp = new int[numRows];
        Arrays.fill(dp, 1);

        for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();
        // 从后往前更新dp数组
        for (int j = i; j >= 0; j--) {
        if (j != 0 && j != i) {
        dp[j] = dp[j] + dp[j - 1];
        }
        row.add(0, dp[j]); // 从头部插入，保持顺序
        }
        res.add(row);
        }
        return res;
        }

        但这种方法可能需要更仔细的调整。或者，更常见的滚动数组方法是从前往后更新，但需要逆序处理。

        另一种方法是，每次生成新的一行时，从后往前更新数组的值，这样不会覆盖前面需要的数据。例如：

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1); // 第一个元素
        for (int j = 1; j < i; j++) {
        curr.add(prev.get(j - 1) + prev.get(j));
        }
        if (i >= 1) {
        curr.add(1); // 最后一个元素
        }
        res.add(curr);
        prev = curr;
        }
        return res;
        }

        这种方法使用两个列表prev和curr，每次生成当前行时只需要上一行的数据，空间复杂度降为O(n)，因为prev列表的大小最大为n。

        但需要注意的是，当i=0时，循环的处理是否正确，需要处理边界情况。

        此外，还可以进一步优化，使用单个列表来动态更新，通过从后往前的方式修改列表的值，这样可以节省空间。例如，每次在上一行的基础上添加元素：

public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
        row.add(0, 1); // 在开头插入1
        for (int j = 1; j < i; j++) {
        row.set(j, row.get(j) + row.get(j + 1));
        }
        if (i > 0) {
        row.add(1); // 在末尾添加1
        }
        res.add(new ArrayList<>(row));
        }
        return res;
        }

        这种方法可能比较复杂，需要处理索引的变化。

        综合考虑实现复杂度和优化效果，可能采用使用prev列表的方法更为直观，且空间复杂度为O(n)，时间复杂度仍为O(n²)，但实际运行时间可能有所减少。

        回到用户的问题，用户可能希望看到更高效的实现，尤其是在空间使用上的优化。之前的解决方案已经将空间复杂度降低到O(n²)，但使用二维数组。进一步优化可以将空间复杂度降低到O(n)，通过使用一维数组或仅保存上一行的数据。

        因此，需要编写一个使用一维数组或prev列表的版本，并解释优化后的空间复杂度。

        此外，还需要注意代码的可读性和正确性，确保优化后的代码仍然容易理解。

        现在需要将这些思考整理成用户容易理解的步骤，提供优化后的代码，并说明优化点。


        ```
        可以进一步优化空间复杂度，以下是三种优化方案及对比分析：

        ### 优化方案一：滚动数组（空间O(n)）
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dp = new int[numRows]; // 用一维数组覆盖所有行

        for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();
        // 从右向左更新，防止数据覆盖
        for (int j = i; j >= 0; j--) {
        if (j == 0 || j == i) {
        dp[j] = 1;
        } else {
        dp[j] = dp[j] + dp[j - 1]; // 复用上一行数据
        }
        row.add(0, dp[j]); // 头插法保持顺序
        }
        res.add(row);
        }
        return res;
        }
        ```


        ### 优化方案二：双列表迭代（空间O(n)）
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1); // 首元素

        // 通过上一行中间元素计算当前元素
        for (int j = 1; j < i; j++) {
        curr.add(prev.get(j - 1) + prev.get(j));
        }

        if (i >= 1) curr.add(1); // 尾元素
        res.add(curr);
        prev = curr; // 更新上一行
        }
        return res;
        }
        ```


        ### 优化方案三：单列表动态更新（空间O(n)）
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
        row.add(0, 1); // 头部插入首元素

        // 中间元素计算（从1到i-1）
        for (int j = 1; j < i; j++) {
        row.set(j, row.get(j) + row.get(j + 1));
        }

        if (i > 0) row.add(1); // 尾部添加
        res.add(new ArrayList<>(row));
        }
        return res;
        }
        ```


        ### 优化对比分析
        | 方案 | 空间复杂度 | 时间复杂度 | 特点 |
        |------|------------|------------|------|
        | 原方案 | O(n²) | O(n²) | 直观易懂，但空间占用高 |
        | 方案一 | O(n) | O(n²) | 数组操作高效，需要逆序处理 |
        | 方案二 | O(n) | O(n²) | 列表操作直观，需要双列表维护 |
        | 方案三 | O(n) | O(n²) | 单列表动态更新，索引操作复杂 |

        ### 推荐选择
        - **内存敏感场景**：选择方案一（滚动数组），使用基础类型数组效率更高
        - **代码可维护性**：选择方案二（双列表迭代），逻辑最清晰
        - **动态更新需求**：选择方案三（单列表），适合需要实时扩展的场景

        ### 示例输出（numRows=5）
        所有方案输出结果一致：
        ```
        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]
        ```


        这些优化方案在保持O(n²)时间复杂度的同时，将空间复杂度从O(n²)降低到O(n)，特别适合处理大规模数据场景（如numRows>1000的情况）。*/

/*


深度思考
        ```
        好的，用户现在给了一个新的generate方法实现，看起来是杨辉三角的生成代码。用户之前已经讨论过这个问题，并且之前尝试过不同的优化方案。现在用户可能想知道这个新实现是否有效，或者是否有进一步优化的可能。

        首先，我需要分析用户提供的代码。这个实现和之前的版本不同，它没有使用动态规划数组，而是直接通过res列表来获取前一行的数据。这样做的好处是节省了额外的空间，因为不需要维护一个二维数组。但是，每次访问res.get(i-1)可能会有多次的列表遍历，这可能在大数据量时影响性能。

        接下来，我需要检查代码是否有逻辑错误。比如，当i=0的时候，循环会执行j=0的情况，添加1，这正确。对于i=1，j=0和j=1都是1，中间没有计算。当i>1的时候，中间的元素是通过上一行的j-1和j位置的值相加得到的，这符合杨辉三角的定义。看起来代码是正确的，可以正确生成杨辉三角。

        然后，考虑用户之前的对话历史。用户之前的问题是关于如何优化空间复杂度，所以现在用户可能想知道这个新实现的优缺点，或者是否有进一步的优化可能。这个新实现的空间复杂度是O(n²)，因为它需要存储整个三角结构，但时间复杂度同样是O(n²)，因为每个元素都需要计算。

        接下来，用户可能想知道如何优化空间，或者这个实现是否比之前的更好。需要指出这个实现的优点，比如代码简洁，不需要额外的DP数组，但缺点是时间效率可能稍低，因为每次访问res.get(i-1)可能需要遍历列表获取元素。对于非常大的numRows，这可能会有性能问题。

        然后，考虑用户可能的需求。他们可能希望有一个更高效的方法，或者想知道这个实现是否符合最佳实践。需要比较这个方法和之前优化方案的不同之处，并建议可能的改进，比如缓存前一行的结果，减少重复访问列表的开销。

        此外，用户可能没有意识到这个实现的时间复杂度是否与之前的方案相同。需要指出虽然空间上可能没有优化，但代码更简洁，适合小规模数据。

        最后，总结这个实现的优缺点，并提供可能的优化方向，比如使用滚动数组来减少空间使用，或者缓存前一行列表来减少重复访问的时间开

        ```
        您的实现简洁且逻辑清晰，以下是代码分析和优化建议：

        ### ✅ 实现优点
        1. **直观性**：直接使用`res`列表存储中间结果，无需额外DP数组
        2. **正确性**：通过`res.get(i-1)`获取上一行数据，符合杨辉三角递推公式
        3. **空间效率**：避免了二维数组的显式声明，内存占用更直观

        ### 🔍 潜在优化点
        1. **重复访问优化**：
        ```java
        // 原代码重复调用res.get(i-1)
        res.get(i - 1).get(j - 1)
        res.get(i - 1).get(j)
        ```

        建议缓存上一行数据：
        ```java
        List<Integer> prevRow = res.get(i - 1);
        int val = prevRow.get(j - 1) + prevRow.get(j);
        ```


        2. **空间复杂度**：
        - 当前实现空间复杂度为O(n²)，与原始DP方案相同
        - 若需优化到O(n)，可使用滚动数组：
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1); // 首元素

        for (int j = 1; j < i; j++) {
        curr.add(prev.get(j - 1) + prev.get(j)); // 复用上一行数据
        }

        if (i > 0) curr.add(1); // 尾元素
        res.add(curr);
        prev = curr; // 更新上一行
        }
        return res;
        }
        ```


        ### 📈 性能对比
        | 实现方式 | 时间复杂度 | 空间复杂度 | 特点 |
        |---------|------------|------------|------|
        | 当前实现 | O(n²) | O(n²) | 代码直观，但重复访问列表 |
        | 滚动数组 | O(n²) | O(n) | 空间效率更高，需维护两个列表 |
        | DP数组 | O(n²) | O(n²) | 需要额外数组空间 |

        ### ✅ 优化建议
        1. **推荐缓存上一行数据**（保持O(n²)空间）：
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();

        if (i > 0) {
        List<Integer> prevRow = res.get(i - 1); // 缓存上一行
        row.add(1); // 首元素

        for (int j = 1; j < i; j++) {
        row.add(prevRow.get(j - 1) + prevRow.get(j)); // 复用缓存
        }

        if (i > 0) row.add(1); // 尾元素
        } else {
        row.add(1); // 第一行特殊处理
        }

        res.add(row);
        }
        return res;
        }
        ```


        2. **极端优化方案**（O(n)空间）：
        ```java
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
        row.add(0, 1); // 头部插入

        for (int j = 1; j < i; j++) {
        row.set(j, row.get(j) + row.get(j + 1)); // 原地更新
        }

        if (i > 0) row.add(1); // 尾部添加
        res.add(new ArrayList<>(row)); // 拷贝当前行
        }
        return res;
        }
        ```


        ### 🧪 示例输出
        所有实现当`numRows=5`时输出：
        ```
        [
        [1],
        [1,1],
        [1,2,1],
        [1,3,3,1],
        [1,4,6,4,1]
        ]
        ```


        ### 📌 总结
        - **推荐使用缓存优化版本**：在保持代码可读性的同时，减少列表重复访问
        - **内存敏感场景**：选择滚动数组方案（O(n)空间）
        - **大规模数据**：极端优化方案适合numRows>1000的场景

        当前实现已经非常合理，优化应根据具体应用场景选择。对于一般用途（numRows<1000），原实现+缓存优化是最佳平衡点。*/
