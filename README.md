# Employee Management API Testing

This project is aimed at testing the Employee Management API endpoints using Rest Assured framework in Java. The API provides CRUD operations for managing employees, including creating, reading, updating, and deleting employee records.

## Table of Contents
- [Setup](#setup)
- [Test Cases](#test-cases)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/employee-management-api-testing.git
   ```
2. **Install Dependencies**:
    - Ensure you have Maven installed. If not, download and install it from [Maven's official website](https://maven.apache.org/download.cgi).
    - Navigate to the project directory and run:
      ```bash
      mvn clean install
      ```

## Test Cases

The project includes test cases for the following CRUD operations:
- **GET Requests**: Retrieve employees by ID.
- **POST Request**: Create a new employee record.
- **PUT Request**: Update an existing employee record.
- **DELETE Request**: Delete an existing employee record.

## Usage

1. **Run Tests**: To execute the test cases, run the following command:
   ```bash
   mvn test
   ```

2. **View Test Reports**: After running the tests, view the test reports located in the `target/surefire-reports` directory.

## Contributing

Contributions are welcome! If you have any suggestions, improvements, or new features to add, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

