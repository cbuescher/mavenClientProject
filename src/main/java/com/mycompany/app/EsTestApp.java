package com.mycompany.app;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * A very basic application using the Elasticsearch transport client
 */
public class EsTestApp
{
    public static void main( String[] args ) throws UnknownHostException {
        try (TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)) {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
            SearchResponse searchResponse = client.prepareSearch().get();
            System.out.println("Response took: " + searchResponse.getTook());
        }
    }
}
