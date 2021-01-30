import React,{Component} from 'react'
class PersonCard extends Component {
    render() {
        const { firstName, lastName,age,color } = this.props;
        return (
            <div>
                <h1>{ lastName} , { firstName }</h1>
                <h3>Age: {age}</h3>
                <h3>Hair Color: {color}</h3>
            </div>
        );
    }
}
export default PersonCard