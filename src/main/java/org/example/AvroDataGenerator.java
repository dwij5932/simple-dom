//package org.example;
//
//import org.apache.avro.Schema;
//import org.apache.avro.generic.GenericData;
//import org.apache.avro.generic.GenericRecord;
//import org.apache.avro.io.DatumWriter;
//import org.apache.avro.io.Encoder;
//import org.apache.avro.io.EncoderFactory;
//import org.apache.avro.specific.SpecificDatumWriter;
//
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.Random;
//
//public class AvroDataGenerator {
//    private static final String SCHEMA_STRING = "{\n" +
//            "  \"type\": \"record\",\n" +
//            "  \"name\": \"OrderStatus\",\n" +
//            "  \"fields\": [\n" +
//            "    {\"name\": \"orderId\", \"type\": \"string\"},\n" +
//            "    {\"name\": \"status\", \"type\": \"string\"},\n" +
//            "    {\"name\": \"timestamp\", \"type\": \"long\"}\n" +
//            "  ]\n" +
//            "}";
//
//    public static void main(String[] args) throws IOException {
//        Schema schema = new Schema.Parser().parse(SCHEMA_STRING);
//        GenericRecord record = new GenericData.Record(schema);
//
//        record.put("orderId", "12345");
//        record.put("status", "PENDING");
//        record.put("timestamp", System.currentTimeMillis());
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        DatumWriter<GenericRecord> writer = new SpecificDatumWriter<>(schema);
//        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
//        writer.write(record, encoder);
//        encoder.flush();
//        out.close();
//
//        byte[] serializedData = out.toByteArray();
//        // Now you can use serializedData to publish to Kafka
//    }
//}
