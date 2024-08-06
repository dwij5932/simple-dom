package org.example;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import java.io.File;
import java.io.IOException;

public class AvroRecordGenerator {
    public static GenericRecord generateRecord() throws IOException {
        Schema schema = new Schema.Parser().parse(new File("C:\\Users\\Dasun Theekshana\\Desktop\\KT\\demo-dom\\src\\main\\resources\\dom.order.status.0-value.avsc"));
        GenericRecord record = new GenericData.Record(schema);

        record.put("orderId", "12345");
        record.put("status", "PENDING");
        record.put("timestamp", System.currentTimeMillis());

        return record;
    }
}
