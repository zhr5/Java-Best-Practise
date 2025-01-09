package com.javaedge.algorithm.leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution207 {
    /**
     * 判断是否可以完成所有课程
     *
     * @param numCourses 课程数
     * @param prerequisites 课程先决条件数组，每个元素为一个包含两个课程编号的数组，表示一门课程是另一门课程的先决条件
     * @return 如果可以完成所有课程，返回true；否则返回false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表，表示课程之间的先决关系
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());

        // 创建标志数组，用于标记课程的访问状态
        int[] flags = new int[numCourses];

        // 根据先决条件填充邻接表
        for(int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);

        // 遍历每门课程，检查是否存在环
        for(int i = 0; i < numCourses; i++)
            if(!dfs(adjacency, flags, i)) return false;

        // 如果所有课程都可以完成，返回true
        return true;
    }

    /**
     * 深度优先搜索课程表中是否存在环
     *
     * @param adjacency 邻接表，表示课程之间的先决关系
     * @param flags 标志数组，用于标记课程的访问状态
     * @param i 当前访问的课程编号
     * @return 如果存在环，返回false；否则返回true
     */
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 如果当前课程正在访问中，说明存在环，返回false
        if(flags[i] == 1) return false;
        // 如果当前课程已经访问完成，返回true
        if(flags[i] == -1) return true;

        // 标记当前课程为正在访问中
        flags[i] = 1;

        // 遍历当前课程的所有先决课程
        for(Integer j : adjacency.get(i))
            // 如果在访问先决课程的过程中发现环，返回false
            if(!dfs(adjacency, flags, j)) return false;

        // 标记当前课程为访问完成
        flags[i] = -1;

        // 返回true，表示当前课程及其先决课程不存在环
        return true;
    }

    /**
 * 判断是否可以完成所有课程的学习。
 *
 * @param numCourses 课程总数
 * @param prerequisites 课程之间的先修关系，prerequisites[i] = [a, b] 表示：想要学习课程 a 必须先完成课程 b
 * @return 如果可以完成所有课程，则返回 true；否则返回 false
 */
public boolean canFinish1(int numCourses, int[][] prerequisites) {
    // 初始化每个课程的入度为 0
    int[] indegrees = new int[numCourses];
    // 初始化邻接表，存储每个课程的后续课程
    List<List<Integer>> adjacency = new ArrayList<>();
    // 使用队列存储入度为 0 的课程
    Queue<Integer> queue = new LinkedList<>();

    // 为每个课程初始化一个空的邻接表
    for (int i = 0; i < numCourses; i++)
        adjacency.add(new ArrayList<>());

    // 获取每个课程的入度和邻接表信息
    for (int[] cp : prerequisites) {
        indegrees[cp[0]]++;  // 增加课程 cp[0] 的入度
        adjacency.get(cp[1]).add(cp[0]);  // 将课程 cp[0] 添加到课程 cp[1] 的邻接表中
    }

    // 获取所有入度为 0 的课程并加入队列
    for (int i = 0; i < numCourses; i++)
        if (indegrees[i] == 0) queue.add(i);

    // 开始广度优先搜索（BFS）进行拓扑排序
    while (!queue.isEmpty()) {
        int pre = queue.poll();  // 从队列中取出一个入度为 0 的课程
        numCourses--;  // 完成该课程后，剩余课程数减 1
        // 遍历该课程的所有后续课程
        for (int cur : adjacency.get(pre)) {
            if (--indegrees[cur] == 0)  // 如果后续课程的入度变为 0，则将其加入队列
                queue.add(cur);
        }
    }

    // 如果所有课程都已完成（numCourses == 0），则返回 true；否则返回 false
    return numCourses == 0;
}


}
