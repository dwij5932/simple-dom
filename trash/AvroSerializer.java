package org.example;

import org.apache.avro.Schema;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericDatumWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AvroSerializer {
    public static byte[] serializeRecord(GenericRecord record, Schema schema) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
        writer.write(record, encoder);
        encoder.flush();
        out.close();

        return out.toByteArray();
    }
}

