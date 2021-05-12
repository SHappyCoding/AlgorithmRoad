public class NumK_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        Queue<int[]> qu=new PriorityQueue<int[]>(new Comparator<int[]>() {  //实现比较器就不会报错，put的时候比较的是第二个元素的大小
            public int compare(int[] m, int[] n) {
                return m[1] - n[1]; //比较个数的大小，添加的时候
            }
        });
        for(int e:nums){
            if(mp.containsKey(e))mp.put(e,mp.get(e)+1);
            else mp.put(e,1);
        }
//        for (int num : nums) {
//            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);   //当Map集合中有这个key时，就使用这个key对应的value值，没有就使用默认值defaultValue
//        }


        for(Map.Entry e:mp.entrySet()){
            int num = (int) e.getKey(), count = (int) e.getValue(); //哈希表的值和次数做成一个含有两个元素的数组：int{e,count}
            if(k==qu.size()) {
                if(qu.peek()[1]<count){
                    qu.poll();
                    qu.offer(new int[]{num,count});
                }
            }
            else{
                qu.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = qu.poll()[0];
        }

        return res;
    }

    public int[] topKFrequen2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();    //列表来做排序工作
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count}); //哈希表的值和次数做成一个含有两个元素的数组：int{e,count}，全部加到列表里面去
        }
        int[] ret = new int[k];
        //快排，找到前K个高频次，其实就是对数组对象的第二个元素count进行排序
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    //排序的列表，开始下标，结束下标，排序后的数组对象K个，作用：利用快排对列表进行排序，基于数组对象的第2个元素count
    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start; //优化随机元素快排
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];   //第一个作为主元（也就是随机后的值）
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {    //基于列表中的第二个元素（count）来进行排序
                Collections.swap(values, index + 1, i); //这是算法导论的排序方式，start-index表示大于等于主元的元素，index-end表示小于主元的元素
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {   //大于K个需要继续排
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {  //小于K个，先前前面的放到结果数组中去
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {    //排缺少的k - (index - start + 1)个
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    public static void main(String[] args) {
        NumK_347 sr=new NumK_347();
        int[] nums={1,1,1,2,2,3};
        int[] res=sr.topKFrequent(nums,2);
        for(int e:res){
            System.out.print(e+" ");
        }
    }
}
