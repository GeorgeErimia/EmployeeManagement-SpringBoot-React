import { useEffect, useState } from "react";
import { deleteEmployee, listEmployees } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";
import { getDepartmentById } from "../services/DepartmentService";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const [department, setDepartment] = useState("");

  const navigator = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  function addNewEmployee() {
    navigator("/add-employee");
  }

  function updateEmployee(employeeId) {
    navigator(`/edit-employee/${employeeId}`);
  }

  function removeEmployee(id) {
    console.log(id);

    deleteEmployee(id)
      .then((response) => {
        getAllEmployees();
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function getAllEmployees() {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }

  function setDepartmentName(id) {
    getDepartmentById(id).then((response) => {
      setDepartment(response.data.departmentDescription);
    });
  }

  return (
    <div className="container">
      <h2> List of Employees</h2>
      <button className="btn btn-primary mb-2" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email</th>
            <th>Employee Department</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => {
            setDepartmentName(employee.departmentId);
            return (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>{department}</td>
                <td>
                  <button
                    className="btn btn-info"
                    onClick={() => updateEmployee(employee.id)}
                  >
                    Update
                  </button>
                  <button
                    type="button"
                    className="btn btn-danger"
                    onClick={() => removeEmployee(employee.id)}
                    style={{ marginLeft: "10px" }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
