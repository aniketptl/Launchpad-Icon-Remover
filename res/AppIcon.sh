#!/usr/bin/env bash


sqlite3 $(sudo find /private/var/folders -name com.apple.dock.launchpad -user $USER)/db/db "DELETE FROM apps WHERE title='$1';";

echo "Reseting Dock ";

killall Dock;

echo "Finished"

