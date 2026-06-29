import java.util.Arrays;

class NetworkPacket {
    private String ipAddress;
    // Private byte array representing raw payload
    private byte[] payload; 

    public NetworkPacket(String ipAddress, byte[] inputPayload) {
        this.ipAddress = ipAddress;
        
        // DEFENSIVE COPY: Don't just assign references. 
        // If external code modifies inputPayload later, our internal data changes.
        this.payload = new byte[inputPayload.length];
        System.arraycopy(inputPayload, 0, this.payload, 0, inputPayload.length);
    }

    // Getter for a mutable array field
    public byte[] getPayload() {
        // DEFENSIVE COPY: Return a clone, not the actual pointer.
        // This ensures the internal state cannot be corrupted from the outside.
        byte[] copy = new byte[this.payload.length];
        System.arraycopy(this.payload, 0, copy, 0, this.payload.length);
        return copy;
    }
    
    public void printPayloadHex() {
        System.out.println("Payload: " + Arrays.toString(this.payload));
    }
}

public class NetworkDemo {
    public static void main(String[] args) {
        byte[] rawData = {0x1A, 0x2B, 0x3C};
        NetworkPacket packet = new NetworkPacket("192.168.1.1", rawData);

        // Attempting a bypass attack by catching the returned array reference
        byte[] leakedPayload = packet.getPayload();
        leakedPayload[0] = 0x7F; // Maliciously changing the data block

        // The packet remains securely uncorrupted due to encapsulation + defensive copying
        packet.printPayloadHex(); // Output retains original: [26, 43, 60]
    }
}
