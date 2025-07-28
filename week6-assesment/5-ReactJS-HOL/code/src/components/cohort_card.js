import React from "react";
import '../App.css';

class CohortCard extends React.Component {
  render() {
    const { cohort } = this.props;

    const statusColorClass = cohort.current_status === 'Scheduled' ? 'status-scheduled' : 'status-ongoing';
    const titleColorClass = cohort.title.includes('Java') ? 'title-java' : 'title-dot-net';

    return (
      <div className="cohort-card">
        <h3 className={`cohort-title ${titleColorClass}`}>
          {cohort.title}
        </h3>
        <div className="cohort-details">
          <p>
            <span className="detail-label">Started On:</span> <span className="detail-value">{cohort.started_on}</span>
          </p>
          <p>
            <span className="detail-label">Current Status:</span>{' '}
            <span className={`detail-value ${statusColorClass}`}>
              {cohort.current_status}
            </span>
          </p>
          <p>
            <span className="detail-label">Coach:</span> <span className="detail-value">{cohort.coach}</span>
          </p>
          <p>
            <span className="detail-label">Trainer:</span> <span className="detail-value">{cohort.trainer}</span>
          </p>
        </div>
      </div>
    );
  }
}

export default CohortCard;