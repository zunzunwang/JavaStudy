package codinggame;

import java.util.List;

/**
 * Created by zunzunwang
 * Date: 13/03/2021
 */
public class FindEndPoint {
    public static int FindNetworkEndPoint(int startNode, List<Integer> fromIds, List<Integer> toIds){
        //corner case
        if(toIds.size() <= 0 ||toIds.size()>10000)
            return 0;

        //intial varaibles
        boolean isStart = true;
        boolean isCycle = false;
        boolean isEnd = false;

        int node = startNode;
        int indexNode = Integer.MIN_VALUE;
        int oldIndex = Integer.MIN_VALUE;

        //loop the network
        while(!isEnd && !isCycle)
        {
            //detect cycle
            if(!isStart && (node == startNode))
            {
                isCycle = true;
                indexNode = oldIndex;
                break;
            }
            //intial
            if(isStart) isStart = false;

            //principal logic
            if(fromIds.contains(node)){
                oldIndex = indexNode;
                int index = fromIds.indexOf(node);
                node = toIds.get(index);

            }else
                isEnd = true;
        }
        return indexNode;
    }

    public static void main(String[] args) {

    }

}
