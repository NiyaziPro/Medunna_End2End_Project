OB#!/bin/bash
formatted_date=$(date +"%H:%M %A %d.%m.%Y")
git add .
git commit -m"$formatted_date"
git push
