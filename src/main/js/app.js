'use strict';

const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');

class App extends React.Component {

    constructor(props) {
    	super(props);
    	this.state = {message: null};
    }

    componentDidMount() {
    	client({method: 'GET', path: '/api/message-of-the-day'}).done(response => {
    		this.setState({message: response.entity.message});
    	});
    }

    render() {
        return (
            <MessageOfTheDay message={this.state.message}/>
        )
    }
}

class MessageOfTheDay extends React.Component {
    render() {
        return (
            <h2>Message of the day is {this.props.message}</h2>
        )
    }
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)