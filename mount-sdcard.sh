 #!/bin/bash
echo "Mounting AVD sgs3-emu SD Card (requires sudo)"
mkdir -p /mnt/sdcard
mount ~/.android/avd/sgs3-emu.avd/sdcard.img -o loop /mnt/sdcard
echo "Successful!"
