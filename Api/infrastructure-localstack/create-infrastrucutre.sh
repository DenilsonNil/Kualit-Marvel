awslocal secretsmanager create-secret --name /secret/client-credentials  --secret-string "{\"client-marvel-public-key\":\"MARVEL_PUBLIC_KEY\", \"client-marvel-private-key\":\"MARVEL_PRIVATE_KEY\"}"

awslocal sns create-topic --name character-picture-topic
awslocal sqs create-queue --queue-name character-picture-queue
awslocal sns subscribe  --region us-east-1 --topic-arn arn:aws:sns:us-east-1:000000000000:character-picture-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:character-picture-queue


awslocal sqs delete-message --queue-url https://localhost.localstack.cloud:4566/000000000000/character-picture-queue --receipt-handle MWRhY2Q3OTgtYTk0Yi00NzMxLTlmNWQtYWRiMzc4ZWUwYzhiIGFybjphd3M6c3FzOnVzLWVhc3QtMTowMDAwMDAwMDAwMDA6Y2hhcmFjdGVyLXBpY3R1cmUtcXVldWUgYzhhY2ViYjUtZTUwZC00NGFmLTgzNTctZWJjNGY2YmQ1NWEyIDE3MDk3NTcxNTcuMzkwMDE2Ng==