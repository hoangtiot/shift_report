<div align='center'>

<p>The Shift Report project is a Java Spring Boot application designed to manage transactions and debts within a single shift. It utilizes MySQL to store transaction data and debts, calculates the total cash for the shift, and sends the summary to the owner.</p>

<h4> <span> · </span> <a href="https://github.com/hoangtiot/Shift Report/blob/master/README.md"> Documentation </a> <span> · </span> <a href="https://github.com/hoangtiot/Shift Report/issues"> Report Bug </a> <span> · </span> <a href="https://github.com/hoangtiot/Shift Report/issues"> Request Feature </a> </h4>


</div>

# :notebook_with_decorative_cover: Table of Contents

- [About the Project](#star2-about-the-project)
- [Roadmap](#compass-roadmap)
- [Contact](#handshake-contact)


## :star2: About the Project

### :dart: Features
- Transaction Management: Record all transactions that occur during a shift, including income and expenses.
- Debt Management: Track debts accumulated during the shift.
- Cash Calculation: Calculate the total cash for the shift, factoring in income, expenses, and debts.
- Owner Notification: Send a summary of the shift's cash total to the owner.


## :compass: Roadmap

* [x] Init and models
* [ ] Record transactions
* [ ] Calculate total
* [ ] Send notifications

### :gear: Installation

Clone the repository:
```bash
git clone [https://github.com/dev-tuanvv/BE-TC.git](https://github.com/hoangtiot/shift_report.git)
```
Navigate to the project directory:
```bash
cd report
```
Install MySQL locally or use a cloud-based MySQL service. Create a new database named capstone_db. Update the MySQL connection settings in the application.properties file.
Build the project image using Dockerfile
```bash
docker build . -t tutorcenter
```
Run the image created in a container
```bash
docker run -p 9000:8080 tutorcenter
```

## :handshake: Contact

hoangtiot - [LinkedIn](https://www.linkedin.com/in/hoangdh1262/) - dohuyhoang1120@gmail.com

Project Link: [https://github.com/hoangtiot/shift_report.git](https://github.com/hoangtiot/shift_report.git)
