# demobank

Demobank is an app with two different deployable services account-api and transaction-api

## How to Run

```bash
docker-compose up --build   
```

## Swagger Endpoints

http://localhost:8081/swagger-ui/index.html

http://localhost:8082/swagger-ui/index.html


## Example Test

You can use postman collection in the source code (DemoBank.postman_collection.json)

Step 1: Create Customer 

```bash
curl --location 'localhost:8081/customer' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Ali Dinçer",
    "surName": "Dere"
}'
```

get the customer id GUID in response and use it in the below request:

Step 2: Create Account

```bash
curl --location 'localhost:8081/account' \
--header 'Content-Type: application/json' \
--data '{
    "customerId":"1f1ae2a9-caac-4ed7-aad0-683ef8191616",
    "initialCredit":"10"
}'
```

Step 3: Get Customer

use the same customer id again in this request

```bash
curl --location 'localhost:8081/customer/1f1ae2a9-caac-4ed7-aad0-683ef8191616'
```

Step 4: Create New Transaction

below use the account id which you can see in above request

```bash
curl --location 'localhost:8082/transaction/process' \
--header 'Content-Type: application/json' \
--data '{
    "amount":15,
    "transactionType":"DEPOSIT",
    "accountId":"b0b710fe-0d72-4776-8852-83651f39b162"
}'
```

you can also try with transaction type "WITHDRAW" as well.
After doing several DEPOSIT and WITHDRAW operations you can apply STEP 3 to see transaction list and customer.

if you apply withdraw more than the account amount you can see insufficient funds error as well.

## Architecture

The solution has two different services built in hexagonal architecture.
Infra and domain layers are separated. Controllers, DTOs, commands, queries, handlers, services, models, ports, adapters, Repositories and Entities are used.