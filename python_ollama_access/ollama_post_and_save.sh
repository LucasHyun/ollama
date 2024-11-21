#!/bin/bash

#These are the steps to run the script

URL="http://localhost:11434/api/generate"

JSON_DATA='{
    "Model": "llama3.2",
    "prompt": "who will be the next president of the united states?",
    "stream": false
}'

# Set the file name to save the output (default: response.json)
OUTPUT_FILE="${1:-response.json}"

# Send the request and save the response to the file
curl -s "$URL" -H "Content-Type: application/json" -d "$JSON_DATA" -o "$OUTPUT_FILE"

# Print the message to the console that the file has been saved
echo "Response has been saved to $OUTPUT_FILE"

