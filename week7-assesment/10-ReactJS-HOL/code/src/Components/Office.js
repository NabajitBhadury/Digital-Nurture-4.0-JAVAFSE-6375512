import colors from "./Office.module.css"

export const OfficeComponent = ({ office }) => {

  var rentColors = [
    colors.rent,
  ]
  if (office.range > 60000)
    rentColors.push(colors.textGreen)
  else
    rentColors.push(colors.textRed)

  return (
    <div className="Office">
      <h2 className={colors.office}>{office.name}</h2>
      <p className={rentColors.join(" ")}> Rang: {office.range}</p>
      <p className={colors.address}> Address: {office.address}</p>
    </div>
  )

}
