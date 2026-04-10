# The-Traffic-Challan-Management-System
🚦 Traffic Challan Management System: A Java console app using JDBC &amp; MySQL to manage traffic violations. Features include issuing challans, tracking payments, viewing unpaid records, generating daily reports &amp; identifying repeat offenders. Built to demonstrate real-world database integration &amp; backend logic.

---

## ✨ Features

* 🚗 Issue challans for traffic violations
* 💳 Mark challans as paid
* 🔍 View unpaid challans by vehicle number
* 📊 Generate daily revenue reports
* ⚠️ Identify repeat offenders
* 🚪 Exit system safely

---

## 🛠️ Technologies Used

* Java (Core Java, JDBC)
* MySQL (Database)
* JDBC Driver

---

## 📁 Project Structure

```
TrafficChallanProject/
│── src/
│   ├── Main.java
│   ├── DBConnection.java
│
│── sql/
│   └── schema.sql
│
│── lib/
│   └── mysql-connector-j-9.6.0.jar
│
│── Screenshots/
│
│── README.md
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository

```bash
git clone https://github.com/codebyshagufta/The-Traffic-Challan-Management-System.git
```

### 2️⃣ Setup Database

* Open MySQL
* Run the SQL file:

```
sql/schema.sql
```

### 3️⃣ Configure Database Connection

Update credentials in `DBConnection.java`:

```java
String url = "jdbc:mysql://localhost:3306/your_db_name";
String user = "root";
String password = "your_password";
```

### 4️⃣ Run the Project

* Compile and run `Main.java`

---

## 📸 Screenshots

### 🏠 Main Menu

![Main Menu](Screenshots/menu.png)

### 🚗 Issue Challan

![Issue Challan](Screenshots/Screenshot1%202026-04-09%20232306.png)

### 🔍 Unpaid Challans

![Unpaid Challans](Screenshots/Screenshot%202026-04-09%20232602.png)

### 📊 Daily Report (Part 1)

![Daily Report 1](Screenshots/Screenshot%202026-04-09%20232531.png)

### 📊 Daily Report (Part 2)

![Daily Report 2](Screenshots/Screenshot%202026-04-09%20232723.png)

### 🚪 Exit

![Exit](Screenshots/Screenshot%202026-04-09%20232744.png)

---

## 🎯 Future Improvements

* GUI version using Java Swing / JavaFX
* User authentication system
* Online payment integration
* Advanced reporting system

---

## 👩‍💻 Author

**Shagufta**
📧 [shagufta1622004@gmail.com](mailto:shagufta1622004@gmail.com)

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
