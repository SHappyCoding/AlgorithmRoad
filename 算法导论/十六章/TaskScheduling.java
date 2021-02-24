public class TaskScheduling {

    //截止时间升序比较器
    public static class DeadlineAscendingComparator implements Comparator<Tasknode> {
        @Override
        public int compare(Tasknode o1, Tasknode o2) {
            //按截止时间升序排列
            return o1.deadline - o2.deadline;
            //开始o1在o2前面，返回正数交换o1，o2的位置
        }
    }

    //加入元素之后独立性判断
    public boolean IsIndependent(ArrayList<Tasknode> PreScheduling,int len){//java现在有类型匹配预测机制
        //len表示总任务S的个数
        int[] C=new int[len+1];
        int size=PreScheduling.size();  //早任务集大小
        for (int i=1;i<size+1;i++){
            C[PreScheduling.get(i-1).deadline]++;
        }
        for (int i=1;i<C.length;i++){
            C[i]=C[i]+C[i-1];
            if (C[i]>i)return false;
        }
        return true;
    }

    //得到最优调度
    public ArrayList BestSchedulingList(ArrayList<Tasknode> PreScheduling,ArrayList<Tasknode> PostScheduling){
        PreScheduling.sort(new DeadlineAscendingComparator());//对列表中的元素按截止时间升序排列
        //PrintScheduling(PreScheduling);
        PostScheduling.sort(new DeadlineAscendingComparator());
        System.out.printf("早任务集：");
        PrintScheduling(PreScheduling);
        System.out.printf("迟任务集：");
        PrintScheduling(PostScheduling);
        PreScheduling.addAll(PostScheduling);
        return PreScheduling;
    }

    //打印列表中的元素
    public void PrintScheduling(ArrayList<Tasknode> BestScheduling){
        for(Tasknode e:BestScheduling){
            System.out.print(e.index+"  ");
        }
        System.out.print("\n");
    }

    //初始化序列1
    public Tasknode[] Sequence1(){
        Tasknode[] tasksequence=new Tasknode[]{
                new Tasknode(1,4,70),
                new Tasknode(2,2,60),
                new Tasknode(3,4,50),
                new Tasknode(4,3,40),
                new Tasknode(5,1,30),
                new Tasknode(6,4,20),
                new Tasknode(7,6,10),
        };
        return tasksequence;
    }

    //初始化序列2
    public Tasknode[] Sequence2(){
        Tasknode[] tasksequence=new Tasknode[]{
                new Tasknode(7,6,60),
                new Tasknode(6,4,50),
                new Tasknode(5,1,40),
                new Tasknode(4,3,30),
                new Tasknode(3,4,20),
                new Tasknode(2,2,10),
                new Tasknode(1,4,0),
        };
        return tasksequence;
    }

    public void GreedSelect(Tasknode[] tasksequence){
        int len=tasksequence.length;
        ArrayList<Tasknode> PreScheduling=new ArrayList<Tasknode>();  //早任务集
        ArrayList<Tasknode> PostScheduling=new ArrayList<Tasknode>();  //迟任务集
        for(int i=0;i<len;i++){
            PreScheduling.add(tasksequence[i]);
            if(!IsIndependent(PreScheduling,len)){//如果这个元素加入集合不独立，则加入迟任务集，并从早任务集中删除
                PreScheduling.remove(tasksequence[i]);
                PostScheduling.add(tasksequence[i]);
            }
        }
        //Ts.PrintScheduling(PreScheduling);
        ArrayList<Tasknode> BestScheduling=BestSchedulingList(PreScheduling,PostScheduling);//将早任务和迟任务集合并成最优调度
        PrintScheduling(BestScheduling);
    }

    public static void main(String[] args) {
        TaskScheduling Ts=new TaskScheduling();
        Tasknode[] tasksequence1=Ts.Sequence1();
        Tasknode[] tasksequence2=Ts.Sequence2();
        Ts.GreedSelect(tasksequence1);
        Ts.GreedSelect(tasksequence2);
    }

}
