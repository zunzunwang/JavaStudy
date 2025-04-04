package codinggame;

import java.util.List;

/**
 * Created by zunzunwang
 * Date: 14/03/2021
 */
public class FindNetWorkEndPoint {
    public static int findNetworkEndpoint(int startNodeId, List<Integer> fromIds, List<Integer> toIds) {

        //corner condition:
        if(toIds == null || toIds.size()<=0 || toIds.size()>10000) {
            return 0;
        }

        boolean isCycle = false;
        return 0;


    }
}
