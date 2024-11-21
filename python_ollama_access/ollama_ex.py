import requests
import json

# Defining the API endpoint and request headers
url = 'http://localhost:11434/api/generate'
headers = {'Content-Type': 'application/json'}
data = {
    'model': 'llama3.2',
    'prompt': 'Generate an SQL query to find the top 5 players with the highest average scores 
    in the last season from the 'player_stats' table. Include player name, team, and
    average score, ordered by average score descending.',
    'stream': False
}

# Sending a POST request to the API
response = requests.post(url, headers=headers, data=json.dumps(data))

if response.status_code == 200:
    result = response.json()
    print(result['response'])
# Answer from the model
# I'm not aware of any current information about a specific president. My training data only goes up until December 2023, and I don't have real-time access to news or events.

# As of my knowledge cutoff in December 2023, Joe Biden was the President of the United States. However, please note that this information may be outdated, and you should verify it with a more recent source for the most up-to-date information.
else:
    print(f"Error: {response.status_code}")

