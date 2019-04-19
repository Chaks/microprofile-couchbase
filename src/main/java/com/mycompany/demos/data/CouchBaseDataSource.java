/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demos.data;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author chaks
 */
@Singleton
public class CouchBaseDataSource {

  @Inject
  @ConfigProperty(name = "couchbase.bootstrap-hosts")
  private String hosts;
  @Inject
  @ConfigProperty(name = "couchbase.bucket.name")
  private String bucketName;

  @Produces
  public Bucket defaultBucket() {
    Cluster cluster = CouchbaseCluster.create(hosts);
    System.out.println(">> Opening default bucket");
    return cluster.openBucket(bucketName);
  }

  public void close(@Disposes Bucket bucket) {
    System.out.println(">> Closing default bucket");
    bucket.close();
  }
}
