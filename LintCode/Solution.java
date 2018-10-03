package LintCode;

import LintCode.PUBLIC_DATA_STRUCTURE.*;
import java.util.*;

public class Solution {

//    /**
//     * @param points: a list of points
//     * @param origin: a point
//     * @param k: An integer
//     * @return: the k closest points
//     */
//        Point original = null;
//
//        int size = 0;
//
//        public Point[] kClosest (Point[]points, Point origin,int k){
//        // write your code here
//
//        // First, construct the min heap, using the distance with origin
//        int len = points.length;
//
//        original = origin;
//
//        Point[] heap = new Point[len];
//
//        for (int i = 0; i < len; i++) {
//            insert(heap, points[i], i);
//        }
//
//        Point[] result = new Point[k];
//
//        for (int i = 0; i < len; i++) {
//            System.out.println(heap[i].x + " " + heap[i].y);
//        }
//
//        for (int i = 0; i < k; i++) {
//            result[i] = pop(heap);
//
//            System.out.println("After Pop " + i + "\n");
//            for (int j = 0; j < size; j++) {
//                System.out.println(heap[j].x + " " + heap[j].y);
//            }
//        }
//
//        return result;
//
//    }
//
//    private void insert(Point[] heap, Point point, int index) {
//
//        if (size == 0) {
//            heap[0] = point;
//            size++;
//            return;
//        }
//
//        size++;
//
//        heap[index] = point;
//
//        minHeapify(heap, index);
//    }
//
//    private int parent(int index) {
//        return (index - 1) / 2;
//    }
//
//    private void minHeapify(Point[] heap, int index) {
//        int parentIndex = parent(index);
//
//        if (parentIndex < 0)
//            return;
//
//        if (IsPointLarger(heap[parentIndex], heap[index])) {
//            Point temp = heap[parentIndex];
//            heap[parentIndex] = heap[index];
//            heap[index] = temp;
//
//            minHeapify(heap, parentIndex);
//        }
//    }
//
//    private boolean IsPointLarger(Point a, Point b) {
//        double aDis = getDistance(a, original);
//
//        double bDis = getDistance(b, original);
//
//        if (aDis > bDis) {
//            return true;
//        } else if (aDis < bDis) {
//            return false;
//        } else {
//            if (a.x > b.x)
//                return true;
//            else if (a.x < b.x)
//                return false;
//            else {
//                if (a.y > b.y)
//                    return true;
//                else
//                    return false;
//            }
//
//        }
//    }
//
//    private Point pop(Point[] heap) {
//
//        Point ele = heap[0];
//
//        Point lastEle = heap[size - 1];
//
//        heap[0] = lastEle;
//
//        minHeapifyFromTop(heap, 0);
//
//        size--;
//
//        return ele;
//    }
//
//    private void minHeapifyFromTop(Point[] heap, int index) {
//        int leftIndex = 2 * index + 1;
//        int rightIndex = 2 * index + 2;
//
//        int smallestIndex = index;
//
//        if (leftIndex > 0 && leftIndex < size && IsPointLarger(heap[smallestIndex], heap[leftIndex]))
//            smallestIndex = leftIndex;
//
//        if (rightIndex > 0 && rightIndex < size && IsPointLarger(heap[smallestIndex], heap[rightIndex]))
//            smallestIndex = rightIndex;
//
//        if (smallestIndex != index) {
//            Point temp = heap[smallestIndex];
//
//            heap[smallestIndex] = heap[index];
//
//            heap[index] = temp;
//
//            minHeapifyFromTop(heap, smallestIndex);
//        }
//    }
//
//    private double getDistance(Point a, Point b) {
//        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
//    }

}