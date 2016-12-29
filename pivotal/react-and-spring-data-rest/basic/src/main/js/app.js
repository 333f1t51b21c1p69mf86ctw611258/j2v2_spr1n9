'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');
// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			employees: [],
			employees2: []
		};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/employees'}).done(response => {
			this.setState({
				employees: response.entity._embedded.employees,
                employees2: response.entity._embedded.employees
			});
		});
	}

	render() {
		return (
			<div>
				<EmployeeList employees={this.state.employees} />
				<EmployeeList2 employees2={this.state.employees2} />
			</div>
		)
	}
}
// end::app[]

// tag::employee-list[]
class EmployeeList extends React.Component{
	render() {
		var employees = this.props.employees.map(employee =>
			<Employee key={employee._links.self.href} employee={employee}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Description</th>
					</tr>
					{employees}
				</tbody>
			</table>
		)
	}
}

class EmployeeList2 extends React.Component{
    render() {
        var employees2 = this.props.employees2.map(employee2 =>
			<Employee2 key={employee2._links.self.href} employee={employee2}/>
        );
        return (
			<table>
				<tbody>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				<tr>
					<td>test</td>
					<td>test</td>
				</tr>
				<tr>
					<td>test</td>
					<td>test</td>
				</tr>
                {employees2}
				</tbody>
			</table>
        )
    }
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.employee.firstName}</td>
				<td>{this.props.employee.lastName}</td>
				<td>{this.props.employee.description}</td>
			</tr>
		)
	}
}

class Employee2 extends React.Component{
    render() {
        return (
			<tr>
				<td>{this.props.employee2.firstName}</td>
				<td>{this.props.employee2.lastName}</td>
			</tr>
        )
    }
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]

