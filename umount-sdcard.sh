 #!/bin/bash
echo "Unmounting AVD sgs3-emu SD Card (requires sudo)"
umount /mnt/sdcard
rmdir /mnt/sdcard
echo "Successful!"
