package com.oracle.gdd.sharding;

import com.oracle.distributeddb.model.CreateDistributedAutonomousDatabaseShardDetails;
import com.oracle.distributeddb.model.CreateDistributedAutonomousDatabaseShardWithDedicatedInfraDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {

    public static void main(String[] args) {


        List<CreateDistributedAutonomousDatabaseShardDetails> mm1 = new ArrayList<>();
        List<CreateDistributedAutonomousDatabaseShardWithDedicatedInfraDetails> mm2 =
        mm1.stream().filter(CreateDistributedAutonomousDatabaseShardWithDedicatedInfraDetails.class::isInstance )
                .map(CreateDistributedAutonomousDatabaseShardWithDedicatedInfraDetails.class::cast)
                .collect(Collectors.toList());
        List<String> kst =
        mm2.stream().flatMap(s->s.getPeerCloudAutonomousVmClusterIds().stream())
                .filter(s->s.startsWith("abc")).collect(Collectors.toList());


    }
}
